package com.mino.bottomsheets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val bottomSheetBehavior:BottomSheetBehavior<View> = BottomSheetBehavior.from(bottomSheet)
        val bottomSheetBehavior:BottomSheetBehavior<View> = BottomSheetBehavior.from(bottomSheet)

        //Ekranning qancha qismigacha ko'tarilishi
        bottomSheetBehavior.isFitToContents = false
        bottomSheetBehavior.halfExpandedRatio = 0.6f

        bottomSheetBehavior.setBottomSheetCallback(object :BottomSheetBehavior.BottomSheetCallback(){
            override fun onStateChanged(bottomSheet: View, newState: Int) {

                when(newState){
                    BottomSheetBehavior.STATE_DRAGGING->{
                        Toast.makeText(applicationContext, "Dragging...", Toast.LENGTH_SHORT).show()
                    }
                    BottomSheetBehavior.STATE_EXPANDED->{
                        Toast.makeText(applicationContext, "Expanded...", Toast.LENGTH_SHORT).show()
                    }
                    BottomSheetBehavior.STATE_COLLAPSED->{
                        Toast.makeText(applicationContext, "Collapsed...", Toast.LENGTH_SHORT).show()
                    }
                }


            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                Toast.makeText(applicationContext, "Sliding...", Toast.LENGTH_SHORT).show()
            }
        })


        btn_dialog.setOnClickListener {
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_COLLAPSED){
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            }else{
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            }
        }


    }
}