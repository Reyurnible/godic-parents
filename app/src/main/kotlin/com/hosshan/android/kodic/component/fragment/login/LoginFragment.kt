package com.hosshan.android.kodic.component.fragment.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import butterknife.bindView
import com.hosshan.android.kodic.R
import com.hosshan.android.kodic.component.activity.MainActivity
import kotlin.platform.platformStatic

/**
 * Created by shunhosaka on 15/09/10.
 */
public class LoginFragment : Fragment() {

    companion object {
        @JvmStatic public fun newInstance(): LoginFragment {
            val fragment: LoginFragment = LoginFragment()
            val args: Bundle = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    val editText: EditText by bindView(R.id.login_edittext)
    val button: Button by bindView(R.id.login_button)


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        LoginComponent.Initializer.init(activity).inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_login, container, false)

        button.setOnClickListener {
            // TODO EditTextの内容を保存する

            val intent: Intent = Intent(activity, MainActivity::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }

        return rootView
    }
}