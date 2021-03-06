// Generated by view binder compiler. Do not edit!
package com.runtimeterror.aild.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.runtimeterror.aild.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAlarmBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button buttonDone;

  @NonNull
  public final Button buttonPlayTest;

  @NonNull
  public final Spinner buttonSound;

  @NonNull
  public final CheckBox checkBoxAutoDismiss;

  @NonNull
  public final EditText editTextAdseconds;

  @NonNull
  public final EditText editTextAlarmTitle;

  @NonNull
  public final ConstraintLayout groupDismissSeconds;

  @NonNull
  public final Guideline guideline3;

  @NonNull
  public final Guideline guideline7;

  @NonNull
  public final Guideline guideline9;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textViewAutodismiss;

  @NonNull
  public final TextView textViewSoundText;

  @NonNull
  public final TimePicker timePicker;

  private FragmentAlarmBinding(@NonNull ConstraintLayout rootView, @NonNull Button buttonDone,
      @NonNull Button buttonPlayTest, @NonNull Spinner buttonSound,
      @NonNull CheckBox checkBoxAutoDismiss, @NonNull EditText editTextAdseconds,
      @NonNull EditText editTextAlarmTitle, @NonNull ConstraintLayout groupDismissSeconds,
      @NonNull Guideline guideline3, @NonNull Guideline guideline7, @NonNull Guideline guideline9,
      @NonNull TextView textView4, @NonNull TextView textViewAutodismiss,
      @NonNull TextView textViewSoundText, @NonNull TimePicker timePicker) {
    this.rootView = rootView;
    this.buttonDone = buttonDone;
    this.buttonPlayTest = buttonPlayTest;
    this.buttonSound = buttonSound;
    this.checkBoxAutoDismiss = checkBoxAutoDismiss;
    this.editTextAdseconds = editTextAdseconds;
    this.editTextAlarmTitle = editTextAlarmTitle;
    this.groupDismissSeconds = groupDismissSeconds;
    this.guideline3 = guideline3;
    this.guideline7 = guideline7;
    this.guideline9 = guideline9;
    this.textView4 = textView4;
    this.textViewAutodismiss = textViewAutodismiss;
    this.textViewSoundText = textViewSoundText;
    this.timePicker = timePicker;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAlarmBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAlarmBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_alarm, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAlarmBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_done;
      Button buttonDone = rootView.findViewById(id);
      if (buttonDone == null) {
        break missingId;
      }

      id = R.id.button_play_test;
      Button buttonPlayTest = rootView.findViewById(id);
      if (buttonPlayTest == null) {
        break missingId;
      }

      id = R.id.button_sound;
      Spinner buttonSound = rootView.findViewById(id);
      if (buttonSound == null) {
        break missingId;
      }

      id = R.id.checkBox_auto_dismiss;
      CheckBox checkBoxAutoDismiss = rootView.findViewById(id);
      if (checkBoxAutoDismiss == null) {
        break missingId;
      }

      id = R.id.edit_text_adseconds;
      EditText editTextAdseconds = rootView.findViewById(id);
      if (editTextAdseconds == null) {
        break missingId;
      }

      id = R.id.edit_text_alarm_title;
      EditText editTextAlarmTitle = rootView.findViewById(id);
      if (editTextAlarmTitle == null) {
        break missingId;
      }

      id = R.id.group_dismiss_seconds;
      ConstraintLayout groupDismissSeconds = rootView.findViewById(id);
      if (groupDismissSeconds == null) {
        break missingId;
      }

      id = R.id.guideline3;
      Guideline guideline3 = rootView.findViewById(id);
      if (guideline3 == null) {
        break missingId;
      }

      id = R.id.guideline7;
      Guideline guideline7 = rootView.findViewById(id);
      if (guideline7 == null) {
        break missingId;
      }

      id = R.id.guideline9;
      Guideline guideline9 = rootView.findViewById(id);
      if (guideline9 == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = rootView.findViewById(id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.text_view_autodismiss;
      TextView textViewAutodismiss = rootView.findViewById(id);
      if (textViewAutodismiss == null) {
        break missingId;
      }

      id = R.id.text_view_sound_text;
      TextView textViewSoundText = rootView.findViewById(id);
      if (textViewSoundText == null) {
        break missingId;
      }

      id = R.id.time_picker;
      TimePicker timePicker = rootView.findViewById(id);
      if (timePicker == null) {
        break missingId;
      }

      return new FragmentAlarmBinding((ConstraintLayout) rootView, buttonDone, buttonPlayTest,
          buttonSound, checkBoxAutoDismiss, editTextAdseconds, editTextAlarmTitle,
          groupDismissSeconds, guideline3, guideline7, guideline9, textView4, textViewAutodismiss,
          textViewSoundText, timePicker);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
