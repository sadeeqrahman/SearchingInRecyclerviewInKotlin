package com.encoders.searchinginrecyclerviewinkotlin.Adapter

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.encoders.searchinginrecyclerviewinkotlin.R
import com.encoders.searchinginrecyclerviewinkotlin.Model.User

class UserListAdapter (
    var users: List<User>,
    var clickListner: onBudgetChartClickListner
) :
    RecyclerView.Adapter<BudgetClistViewHolder>() {

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BudgetClistViewHolder {
        return BudgetClistViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.single_user_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BudgetClistViewHolder, position: Int) {
        holder.initialize(users[position], clickListner)

    }


    fun filterList(filtered_User: List<User>) {
        users = filtered_User
        notifyDataSetChanged()
    }

}

class BudgetClistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var name: TextView? = null
    private var age: TextView? = null

    fun initialize(user: User, action: onBudgetChartClickListner) {
        name = itemView.findViewById(R.id.name)
        age = itemView.findViewById(R.id.age)

        name?.text = user.name
        age?.text = user.age


        itemView?.setOnClickListener {
            action.onBudgetChartClickListner(user, adapterPosition)
        }


    }

}

interface onBudgetChartClickListner {
    fun onBudgetChartClickListner(user: User, position: Int)

}