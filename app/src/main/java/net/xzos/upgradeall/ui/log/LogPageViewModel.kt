package net.xzos.upgradeall.ui.log

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import net.xzos.upgradeall.core.utils.log.LogDataProxy
import net.xzos.upgradeall.core.utils.log.ObjectTag

class LogPageViewModel : ViewModel() {

    private val mLogObjectTag = MutableLiveData<ObjectTag>()
    internal val logList = Transformations.map(mLogObjectTag) { objectTag ->
        LogDataProxy.getLogMessageList(objectTag)
    }

    internal fun setLogObjectTag(logObjectTag: ObjectTag) {
        mLogObjectTag.value = logObjectTag
    }
}