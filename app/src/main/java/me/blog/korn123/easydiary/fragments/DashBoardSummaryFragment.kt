package me.blog.korn123.easydiary.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.aafactory.commons.utils.DateUtils
import kotlinx.android.synthetic.main.fragment_dashboard_summary.*
import me.blog.korn123.easydiary.R
import me.blog.korn123.easydiary.extensions.config

class DashBoardSummaryFragment : androidx.fragment.app.Fragment() {

    /***************************************************************************************************
     *   override functions
     *
     ***************************************************************************************************/
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_dashboard_summary, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        context?.let { ctx ->
            val diaryBackupUsingGMSMillis = ctx.config.diaryBackupGoogle
            diaryBackupUsingGMS.text = when {
                diaryBackupUsingGMSMillis > 0L -> DateUtils.getFullPatternDate(diaryBackupUsingGMSMillis)
                else -> "No backup information"
            }
        }
        attachedPhotoBackupUsingGMS.text = DateUtils.getFullPatternDate(System.currentTimeMillis())
        diaryBackupLocal.text = DateUtils.getFullPatternDate(System.currentTimeMillis())
        attachedPhotoBackupLocal.text = DateUtils.getFullPatternDate(System.currentTimeMillis())
    }
}