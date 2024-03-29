// Generated by view binder compiler. Do not edit!
package uz.texnopos.mybuilderapp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import uz.texnopos.mybuilderapp.R;

public final class FragmentFavoriteBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView textNotifications;

  @NonNull
  public final AppBarMainBinding toolbar;

  private FragmentFavoriteBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView textNotifications, @NonNull AppBarMainBinding toolbar) {
    this.rootView = rootView;
    this.textNotifications = textNotifications;
    this.toolbar = toolbar;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentFavoriteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentFavoriteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_favorite, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentFavoriteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.text_notifications;
      TextView textNotifications = rootView.findViewById(id);
      if (textNotifications == null) {
        break missingId;
      }

      id = R.id.toolbar;
      View toolbar = rootView.findViewById(id);
      if (toolbar == null) {
        break missingId;
      }
      AppBarMainBinding binding_toolbar = AppBarMainBinding.bind(toolbar);

      return new FragmentFavoriteBinding((ConstraintLayout) rootView, textNotifications,
          binding_toolbar);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
