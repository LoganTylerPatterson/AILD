package com.runtimeterror.aild.fragments;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002 !B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0018\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016J\u0016\u0010\u001c\u001a\u00020\n2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0002R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/runtimeterror/aild/fragments/AlarmListFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lcom/runtimeterror/aild/fragments/AlarmListFragment$AlarmListAdapter;", "binding", "Lcom/runtimeterror/aild/databinding/FragmentAlarmListBinding;", "viewModel", "Lcom/runtimeterror/aild/viewmodels/AlarmListViewModel;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/View;", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onStart", "updateUI", "alarms", "", "Lcom/runtimeterror/aild/db/entities/Alarm;", "AlarmListAdapter", "AlarmViewHolder", "app_debug"})
public final class AlarmListFragment extends androidx.fragment.app.Fragment {
    private com.runtimeterror.aild.databinding.FragmentAlarmListBinding binding;
    private com.runtimeterror.aild.fragments.AlarmListFragment.AlarmListAdapter adapter;
    private com.runtimeterror.aild.viewmodels.AlarmListViewModel viewModel;
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    private final void updateUI(java.util.List<com.runtimeterror.aild.db.entities.Alarm> alarms) {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public void onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu, @org.jetbrains.annotations.NotNull()
    android.view.MenuInflater inflater) {
    }
    
    public AlarmListFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00030\u0001B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u001c\u0010\u0012\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0013\u001a\u00060\u0002R\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0010H\u0016R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0017"}, d2 = {"Lcom/runtimeterror/aild/fragments/AlarmListFragment$AlarmListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/runtimeterror/aild/fragments/AlarmListFragment$AlarmViewHolder;", "Lcom/runtimeterror/aild/fragments/AlarmListFragment;", "alarmList", "", "Lcom/runtimeterror/aild/db/entities/Alarm;", "(Lcom/runtimeterror/aild/fragments/AlarmListFragment;Ljava/util/List;)V", "getAlarmList", "()Ljava/util/List;", "setAlarmList", "(Ljava/util/List;)V", "bind", "", "holder", "position", "", "getItemCount", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_debug"})
    public final class AlarmListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.runtimeterror.aild.fragments.AlarmListFragment.AlarmViewHolder> {
        @org.jetbrains.annotations.NotNull()
        private java.util.List<com.runtimeterror.aild.db.entities.Alarm> alarmList;
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.runtimeterror.aild.fragments.AlarmListFragment.AlarmViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.ViewGroup parent, int viewType) {
            return null;
        }
        
        @java.lang.Override()
        public int getItemCount() {
            return 0;
        }
        
        @java.lang.Override()
        public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
        com.runtimeterror.aild.fragments.AlarmListFragment.AlarmViewHolder holder, int position) {
        }
        
        private final void bind(com.runtimeterror.aild.fragments.AlarmListFragment.AlarmViewHolder holder, int position) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.runtimeterror.aild.db.entities.Alarm> getAlarmList() {
            return null;
        }
        
        public final void setAlarmList(@org.jetbrains.annotations.NotNull()
        java.util.List<com.runtimeterror.aild.db.entities.Alarm> p0) {
        }
        
        public AlarmListAdapter(@org.jetbrains.annotations.NotNull()
        java.util.List<com.runtimeterror.aild.db.entities.Alarm> alarmList) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0019\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\u00110\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0014\u001a\n \u000b*\u0004\u0018\u00010\u00110\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001c\u001a\n \u000b*\u0004\u0018\u00010\n0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\rR\u0019\u0010\u001e\u001a\n \u000b*\u0004\u0018\u00010\n0\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\r\u00a8\u0006 "}, d2 = {"Lcom/runtimeterror/aild/fragments/AlarmListFragment$AlarmViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/runtimeterror/aild/fragments/AlarmListFragment;Landroid/view/View;)V", "activeSwitch", "Landroidx/appcompat/widget/SwitchCompat;", "getActiveSwitch", "()Landroidx/appcompat/widget/SwitchCompat;", "alarmTitle", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getAlarmTitle", "()Landroid/widget/TextView;", "amTextView", "getAmTextView", "autoDismissCheckBox", "Landroid/widget/CheckBox;", "getAutoDismissCheckBox", "()Landroid/widget/CheckBox;", "deletCheckbox", "getDeletCheckbox", "id", "", "getId", "()I", "setId", "(I)V", "textView", "getTextView", "timeTextView", "getTimeTextView", "app_debug"})
    public final class AlarmViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView alarmTitle = null;
        private final android.widget.TextView timeTextView = null;
        private final android.widget.CheckBox deletCheckbox = null;
        private final android.widget.TextView amTextView = null;
        private final android.widget.TextView textView = null;
        @org.jetbrains.annotations.NotNull()
        private final androidx.appcompat.widget.SwitchCompat activeSwitch = null;
        private final android.widget.CheckBox autoDismissCheckBox = null;
        private int id = 0;
        
        public final android.widget.TextView getAlarmTitle() {
            return null;
        }
        
        public final android.widget.TextView getTimeTextView() {
            return null;
        }
        
        public final android.widget.CheckBox getDeletCheckbox() {
            return null;
        }
        
        public final android.widget.TextView getAmTextView() {
            return null;
        }
        
        public final android.widget.TextView getTextView() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.appcompat.widget.SwitchCompat getActiveSwitch() {
            return null;
        }
        
        public final android.widget.CheckBox getAutoDismissCheckBox() {
            return null;
        }
        
        public final int getId() {
            return 0;
        }
        
        public final void setId(int p0) {
        }
        
        public AlarmViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
}