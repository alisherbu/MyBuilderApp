// Generated by view binder compiler. Do not edit!
package uz.texnopos.mybuilderapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import uz.texnopos.mybuilderapp.R;

public final class FragmentPersonalInfo0Binding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final MaterialButton btnContinue;

  @NonNull
  public final TextInputEditText etEmail;

  @NonNull
  public final TextInputEditText etFullName;

  @NonNull
  public final TextInputEditText etPhone;

  @NonNull
  public final TextInputLayout inputEmail;

  @NonNull
  public final TextInputLayout inputFullName;

  @NonNull
  public final TextInputLayout inputPhone;

  @NonNull
  public final AppBarMainBinding toolbar;

  private FragmentPersonalInfo0Binding(@NonNull RelativeLayout rootView,
      @NonNull MaterialButton btnContinue, @NonNull TextInputEditText etEmail,
      @NonNull TextInputEditText etFullName, @NonNull TextInputEditText etPhone,
      @NonNull TextInputLayout inputEmail, @NonNull TextInputLayout inputFullName,
      @NonNull TextInputLayout inputPhone, @NonNull AppBarMainBinding toolbar) {
    this.rootView = rootView;
    this.btnContinue = btnContinue;
    this.etEmail = etEmail;
    this.etFullName = etFullName;
    this.etPhone = etPhone;
    this.inputEmail = inputEmail;
    this.inputFullName = inputFullName;
    this.inputPhone = inputPhone;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentPersonalInfo0Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentPersonalInfo0Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_personal_info_0, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentPersonalInfo0Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnContinue;
      MaterialButton btnContinue = rootView.findViewById(id);
      if (btnContinue == null) {
        break missingId;
      }

      id = R.id.etEmail;
      TextInputEditText etEmail = rootView.findViewById(id);
      if (etEmail == null) {
        break missingId;
      }

      id = R.id.etFullName;
      TextInputEditText etFullName = rootView.findViewById(id);
      if (etFullName == null) {
        break missingId;
      }

      id = R.id.etPhone;
      TextInputEditText etPhone = rootView.findViewById(id);
      if (etPhone == null) {
        break missingId;
      }

      id = R.id.inputEmail;
      TextInputLayout inputEmail = rootView.findViewById(id);
      if (inputEmail == null) {
        break missingId;
      }

      id = R.id.inputFullName;
      TextInputLayout inputFullName = rootView.findViewById(id);
      if (inputFullName == null) {
        break missingId;
      }

      id = R.id.inputPhone;
      TextInputLayout inputPhone = rootView.findViewById(id);
      if (inputPhone == null) {
        break missingId;
      }

      id = R.id.toolbar;
      View toolbar = rootView.findViewById(id);
      if (toolbar == null) {
        break missingId;
      }
      AppBarMainBinding binding_toolbar = AppBarMainBinding.bind(toolbar);

      return new FragmentPersonalInfo0Binding((RelativeLayout) rootView, btnContinue, etEmail,
          etFullName, etPhone, inputEmail, inputFullName, inputPhone, binding_toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}