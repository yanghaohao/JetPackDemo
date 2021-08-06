package com.example.yanghao.tourcommercialtenant

/**
 * 常量
 * @author younghow
 * @date 2021/8/6
 */
object Constant {
    // request参数
    /**
     * 打开扫描界面请求码
     */
    const val REQ_QR_CODE = 11002

    /**
     * 打开摄像头
     */
    const val REQ_PERM_CAMERA = 11003
    const val INTENT_EXTRA_KEY_QR_SCAN = "qr_scan_result"
    const val INTENT_EXTRA_KEY_QR_SCAN_COUPON = "获取到的参数"
}