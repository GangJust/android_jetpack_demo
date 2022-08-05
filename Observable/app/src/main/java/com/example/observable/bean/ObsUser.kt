package com.example.observable.bean

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.example.observable.BR


class ObsUser : BaseObservable() {

    @get:Bindable
    var name: String = ""
        set(value) {
            //name = value //不要这么写, 用field来代替, 这么写默认调用的是setName()会造成死递归.
            field = value
            notifyPropertyChanged(BR.name)
        }

    @get:Bindable
    var age: Int = 0
        set(value) {
            field = value
            //notifyChange() //更新所有实例
            notifyPropertyChanged(BR.age)
        }

    @get:Bindable
    var member: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.member)
        }
}