package com.github.xiaosongfu.jakarta.dto

/**
 * 请求响应体
 *
 * code: 响应码
 * msg: 响应信息
 * data: 响应数据
 */
class R<T> private constructor(var code: Int = CODE_SUCCESS, var msg: String = MSG_SUCCESS, var data: T? = null) {

    companion object {

        // 请求成功
        fun <T> success(code: Int = CODE_SUCCESS, msg: String = MSG_SUCCESS, data: T? = null): R<T> {
            return R(code = code, msg = msg, data = data)
        }

        // 请求失败
        fun failed(code: Int = CODE_FAILED, msg: String = MSG_FAILED): R<Void> {
            return R(code = code, msg = msg)
        }

        // --- --- --- --- --- --- --- --- --- --- --- ---

        private const val CODE_SUCCESS = 200
        private const val CODE_FAILED = 500

        const val MSG_SUCCESS = "操作成功"
        const val MSG_FAILED = "操作失败"

        // --- --- --- --- --- --- --- --- --- --- --- ---

        const val CODE_NOT_FOUND = 404
        const val CODE_SERVICE_ERROR = 505
    }
}
