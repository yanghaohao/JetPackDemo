package com.example.yanghao.tourcommercialtenant

import android.annotation.TargetApi
import android.content.Context
import android.content.CursorLoader
import android.net.Uri
import android.os.Build
import android.provider.DocumentsContract
import android.provider.MediaStore

/**
 * Uri路径工具
 * @author younghow
 * @date 2021/8/6
 */
object UriUtil {
    /**
     * 根据图片的Uri获取图片的绝对路径(适配多种API)
     *
     * @return 如果Uri对应的图片存在, 那么返回该图片的绝对路径, 否则返回null
     */
    fun getRealPathFromUri(context: Context, uri: Uri): String? {
        val sdkVersion = Build.VERSION.SDK_INT
        if (sdkVersion < NumberConstant.NUMBER_ELEVEN) {
            return getRealPathFromUriBelowApi11(context, uri)
        }
        return if (sdkVersion < NumberConstant.NUMBER_NINETEEN) {
            getRealPathFromUriApi11To18(context, uri)
        } else {
            getRealPathFromUriAboveApi19(context, uri)
        }
    }

    /**
     * 适配api19以上,根据uri获取图片的绝对路径
     */
    @TargetApi(Build.VERSION_CODES.KITKAT)
    private fun getRealPathFromUriAboveApi19(context: Context, uri: Uri): String? {
        var filePath: String? = null
        val wholeId = DocumentsContract.getDocumentId(uri)

        // 使用':'分割
        val ids = wholeId.split(StringConstant.COLON).toTypedArray()
        val id: String
        id = if (ids.size > 1) {
            ids[1]
        } else {
            ids[0]
        }
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val selection = MediaStore.Images.Media._ID + "=?"
        val selectionArgs = arrayOf(id)
        val cursor = context.contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            projection, selection, selectionArgs, null
        )
        val columnIndex = cursor.getColumnIndex(projection[0])
        if (cursor.moveToFirst()) {
            filePath = cursor.getString(columnIndex)
        }
        cursor.close()
        return filePath
    }

    /**
     * 适配api11-api18,根据uri获取图片的绝对路径
     */
    private fun getRealPathFromUriApi11To18(context: Context, uri: Uri): String? {
        var filePath: String? = null
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val loader = CursorLoader(context, uri, projection, null, null, null)
        val cursor = loader.loadInBackground()
        if (cursor != null) {
            cursor.moveToFirst()
            filePath = cursor.getString(cursor.getColumnIndex(projection[0]))
            cursor.close()
        }
        return filePath
    }

    /**
     * 适配api11以下(不包括api11),根据uri获取图片的绝对路径
     */
    private fun getRealPathFromUriBelowApi11(context: Context, uri: Uri): String? {
        var filePath: String? = null
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = context.contentResolver.query(uri, projection, null, null, null)
        if (cursor != null) {
            cursor.moveToFirst()
            filePath = cursor.getString(cursor.getColumnIndex(projection[0]))
            cursor.close()
        }
        return filePath
    }
}