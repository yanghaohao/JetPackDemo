package com.example.yanghao.tourcommercialtenant

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }


    // 开始扫码
    private fun startQrCode() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // 申请权限
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), Constant.REQ_PERM_CAMERA)
            return
        }
        // 二维码扫码
        startActivityForResult(intent, Constant.REQ_QR_CODE)
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //扫描结果回调
        if (requestCode == Constant.REQ_QR_CODE && resultCode == Activity.RESULT_OK) {
            val bundle = data!!.extras
            val scanResult = bundle!!.getString(Constant.INTENT_EXTRA_KEY_QR_SCAN)

            getCouponInfo(scanResult)
            val i:Intent = intent
            i.putExtra(Constant.INTENT_EXTRA_KEY_QR_SCAN_COUPON,scanResult)
            startActivity(i)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            Constant.REQ_PERM_CAMERA ->
                // 摄像头权限申请
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // 获得授权
                    startQrCode()
                } else {
                    // 被禁止授权
                    Toast.makeText(this, "请至权限中心打开本应用的相机访问权限", Toast.LENGTH_LONG).show()
                }
        }
    }

    private fun getCouponInfo(url:String){
        val client = OkHttpClient()
        val request = Request.Builder()
                .url(url)
                .build()
        val call = client.newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {

            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {

            }
        })
    }
}
