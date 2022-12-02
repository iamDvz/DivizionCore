package ru.iamdvz.core.utils

object ParserUtil {
    @JvmStatic
    fun getFrom(str: String): String? {
        return if (str.contains("{") && str.contains("}")) {
            str.substring(str.indexOf("{") + 1, str.lastIndexOf("}"))
        } else null
    }

    @JvmStatic
    fun getParameterFromArr(strArr: Array<String>, parameterName: String?): String? {
        for (str in strArr) {
            if (str.contains(parameterName!!)) {
                return str.substring(str.indexOf(":") + 1)
            }
        }
        return null
    }

    @JvmStatic
    fun getParameters(str: String): Array<String> {
        return str.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
    }
}