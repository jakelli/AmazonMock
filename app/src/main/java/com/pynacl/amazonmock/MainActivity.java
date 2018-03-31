package com.pynacl.amazonmock;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.pynacl.amazonmock.databinding.ActivityMainBinding;
import com.pynacl.amazonmock.models.Product;

public class MainActivity extends AppCompatActivity implements IMainActivity {

	// data binding
	ActivityMainBinding mBinding;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

		init();
	}

	private void init() {
		MainFragment fragment = new MainFragment();
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.main_container, fragment, "Main");
		transaction.commit();
	}


	@Override
	public void inflateViewProductFragment(Product product) {
		ViewProductFragment fragment = new ViewProductFragment();

		Bundle bundle = new Bundle();
		bundle.putParcelable(getString(R.string.intent_product), product);
		fragment.setArguments(bundle);

		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.main_container, fragment, getString(R.string.fragment_view_product));
		transaction.addToBackStack(getString(R.string.fragment_view_product));
		transaction.commit();
	}
}
