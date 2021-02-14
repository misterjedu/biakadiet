package ng.com.jedun.biakadiet.widgets


import android.content.Context
import android.os.Parcelable
import android.util.AttributeSet
import com.jaredrummler.materialspinner.MaterialSpinner

class FixedMaterialSpinner : MaterialSpinner {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onRestoreInstanceState(savedState: Parcelable?) {
        super.onRestoreInstanceState(null)
    }
}