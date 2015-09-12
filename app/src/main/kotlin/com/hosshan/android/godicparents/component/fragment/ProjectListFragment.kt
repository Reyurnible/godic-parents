package com.hosshan.android.godicparents.component.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cookpad.android.rxt4a.operators.OperatorAddToCompositeSubscription
import com.cookpad.android.rxt4a.schedulers.AndroidSchedulers
import com.hosshan.android.godicparents.component.adapter.ProjectAdapter
import com.hosshan.android.godicparents.model.Project
import com.hosshan.android.godicparents.store.ProjectStoreAdapter
import com.hosshan.android.godicparents.R
import rx.Subscriber
import java.util.ArrayList
import kotlin.platform.platformStatic

/**
 * Created by shunhosaka on 15/09/12.
 */
public class ProjectListFragment : BaseFragment() {

    val adapter: ProjectAdapter

    companion object {
        platformStatic public fun newInstance(): ProjectListFragment {
            val fragment: ProjectListFragment = ProjectListFragment()
            val args: Bundle = Bundle()
            fragment.setArguments(args)
            return fragment
        }
    }

    init {
        // initialize
        adapter = ProjectAdapter(ArrayList<Project>())
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view: View? = inflater?.inflate(R.layout.fragment_project_list, container, false)

        val recyclerView: RecyclerView = view?.findViewById(R.id.project_list_recyclerview) as RecyclerView
        recyclerView.setLayoutManager(LinearLayoutManager(getActivity()))
        recyclerView.setAdapter(adapter)

        getProjectList()

        return view
    }

    private fun getProjectList() {
        ProjectStoreAdapter
                .getProjectList(getActivity())
                .observeOn(AndroidSchedulers.mainThread())
                .lift(OperatorAddToCompositeSubscription<List<Project>>(compositeSubscription))
                .subscribe(object : Subscriber<List<Project>>() {
                    override fun onCompleted() {

                    }

                    override fun onError(e: Throwable?) {

                    }

                    override fun onNext(items: List<Project>?) {
                        adapter.addAll(items)
                    }
                })
    }

}