package com.app.onboardinglibrary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.library.R
import com.app.library.databinding.ItemOnboardingBinding

class AdapterOnBoarding(
    private var list: ArrayList<OnBoarding>
) : RecyclerView.Adapter<AdapterOnBoarding.ViewHolderOnBoarding>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderOnBoarding {
        val binding: ItemOnboardingBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_onboarding, parent, false
        )
        binding.root.layoutParams = ConstraintLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        return ViewHolderOnBoarding(binding)
    }

    override fun getItemCount(): Int {
        return if (list.size > 0) list.size else 0
    }

    override fun onBindViewHolder(holder: ViewHolderOnBoarding, position: Int) {
        val model = list[position]
        holder.bind(model)
    }

    class ViewHolderOnBoarding(binding: ItemOnboardingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        var itemRowBinding: ItemOnboardingBinding = binding
        fun bind(obj: Any?) {
//            itemRowBinding.model = obj as OnBoarding
        //    itemRowBinding.setVariable(BR.model, obj)
            itemRowBinding.executePendingBindings()
        }
    }
}