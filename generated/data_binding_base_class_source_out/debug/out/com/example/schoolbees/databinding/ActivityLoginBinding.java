// Generated by view binder compiler. Do not edit!
package com.example.schoolbees.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.schoolbees.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button button3;

  @NonNull
  public final Button button7;

  @NonNull
  public final EditText editTextLoginPassword;

  @NonNull
  public final EditText editTextLoginUserName;

  @NonNull
  public final TextView textLoginUser;

  @NonNull
  public final TextView textView4;

  private ActivityLoginBinding(@NonNull ConstraintLayout rootView, @NonNull Button button3,
      @NonNull Button button7, @NonNull EditText editTextLoginPassword,
      @NonNull EditText editTextLoginUserName, @NonNull TextView textLoginUser,
      @NonNull TextView textView4) {
    this.rootView = rootView;
    this.button3 = button3;
    this.button7 = button7;
    this.editTextLoginPassword = editTextLoginPassword;
    this.editTextLoginUserName = editTextLoginUserName;
    this.textLoginUser = textLoginUser;
    this.textView4 = textView4;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button3;
      Button button3 = ViewBindings.findChildViewById(rootView, id);
      if (button3 == null) {
        break missingId;
      }

      id = R.id.button7;
      Button button7 = ViewBindings.findChildViewById(rootView, id);
      if (button7 == null) {
        break missingId;
      }

      id = R.id.editTextLoginPassword;
      EditText editTextLoginPassword = ViewBindings.findChildViewById(rootView, id);
      if (editTextLoginPassword == null) {
        break missingId;
      }

      id = R.id.editTextLoginUserName;
      EditText editTextLoginUserName = ViewBindings.findChildViewById(rootView, id);
      if (editTextLoginUserName == null) {
        break missingId;
      }

      id = R.id.textLoginUser;
      TextView textLoginUser = ViewBindings.findChildViewById(rootView, id);
      if (textLoginUser == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      return new ActivityLoginBinding((ConstraintLayout) rootView, button3, button7,
          editTextLoginPassword, editTextLoginUserName, textLoginUser, textView4);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
