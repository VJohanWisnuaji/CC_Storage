package com.studytrial.ccstorage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_edit_memo.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.ParsePosition
import java.text.SimpleDateFormat
import java.util.*



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EditMemoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class EditMemoFragment : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var db: MemoDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_memo, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        et_edit_tanggal.setText(tanggal)
        et_edit_memo.setText(isiMemo)

        MemoDatabase.getInstance(context!!)?.let {
            db = it
        }

        tv_update_edit.setOnClickListener {
            val df = SimpleDateFormat("dd-MM-yyyy", Locale.KOREA)
            val myDate = df.parse(et_edit_tanggal.text.toString())
            listMemo.apply {
                isimemo = et_edit_memo.text.toString()
                tanggal = myDate.toString()
            }

            GlobalScope.launch {
                val memoUpdate = db.memoDao().updateMemo(listMemo)
            }
            dismiss()
            (activity as ProfileActivity).fetchData()
        }

        tv_hapus_edit.setOnClickListener {
            GlobalScope.launch {
                val delete = db.memoDao().deleteMemo(listMemo)
            }
            dismiss()
            (activity as ProfileActivity).fetchData()
        }

    }


    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    companion object {
        lateinit var tanggal: String
        lateinit var isiMemo: String
        lateinit var listMemo: Memo
        fun newInstance(date: String, memo: String, list: Memo): EditMemoFragment {
            tanggal = date
            isiMemo = memo
            listMemo = list
            return EditMemoFragment()
        }
    }
}