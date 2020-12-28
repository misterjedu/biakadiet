package ng.com.jedun.biakadiet.util

import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView

object SpannableHelper {
    fun spannable(
        textView: TextView,
        start: Int,
        end: Int,
        foreGroundColor: Int,
        setUnderline: Boolean = false,
        onSpannableClick: (() -> Unit)? = null
    ) {

        val clickableSpan: ClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                onSpannableClick?.invoke()
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.color = foreGroundColor
                ds.isUnderlineText = setUnderline
            }
        }

        val spannable = SpannableStringBuilder(textView.text)
        spannable.setSpan(
            clickableSpan,
            start,
            end,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        textView.text = spannable
        textView.movementMethod = LinkMovementMethod.getInstance()
    }
}