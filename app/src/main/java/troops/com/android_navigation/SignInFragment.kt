package troops.com.android_navigation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.Navigation


class SignInFragment : Fragment() {

    private var nameEditText: EditText? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tv = view.findViewById<TextView>(R.id.email)

        val bundle = Bundle()
        bundle.putString("data", "DAA")
        view.findViewById<Button>(R.id.signIn)?.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.homeFragment, bundle)
        )
    }

}
