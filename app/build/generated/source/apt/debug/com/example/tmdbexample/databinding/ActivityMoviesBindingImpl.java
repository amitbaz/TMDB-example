package com.example.tmdbexample.databinding;
import com.example.tmdbexample.R;
import com.example.tmdbexample.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMoviesBindingImpl extends ActivityMoviesBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.FrameLayout mboundView0;
    @NonNull
    private final android.widget.TextView mboundView3;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMoviesBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private ActivityMoviesBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (androidx.recyclerview.widget.RecyclerView) bindings[1]
            , (androidx.core.widget.ContentLoadingProgressBar) bindings[2]
            );
        this.listOfMovies.setTag(null);
        this.mboundView0 = (android.widget.FrameLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
        this.spinnerLoading.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.model == variableId) {
            setModel((com.example.tmdbexample.viewmodel.MoviesViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setModel(@Nullable com.example.tmdbexample.viewmodel.MoviesViewModel Model) {
        this.mModel = Model;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.model);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeModelLoading((androidx.databinding.ObservableInt) object, fieldId);
            case 1 :
                return onChangeModelShowEmpty((androidx.databinding.ObservableInt) object, fieldId);
        }
        return false;
    }
    private boolean onChangeModelLoading(androidx.databinding.ObservableInt ModelLoading, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeModelShowEmpty(androidx.databinding.ObservableInt ModelShowEmpty, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        int modelShowEmptyGet = 0;
        com.example.tmdbexample.viewmodel.MoviesViewModel model = mModel;
        androidx.databinding.ObservableInt modelLoading = null;
        com.example.tmdbexample.adapter.MoviesAdapter modelGetAdapter = null;
        int modelLoadingGet = 0;
        androidx.databinding.ObservableInt modelShowEmpty = null;

        if ((dirtyFlags & 0xfL) != 0) {


            if ((dirtyFlags & 0xdL) != 0) {

                    if (model != null) {
                        // read model.loading
                        modelLoading = model.loading;
                    }
                    updateRegistration(0, modelLoading);


                    if (modelLoading != null) {
                        // read model.loading.get()
                        modelLoadingGet = modelLoading.get();
                    }
            }
            if ((dirtyFlags & 0xcL) != 0) {

                    if (model != null) {
                        // read model.getAdapter()
                        modelGetAdapter = model.getAdapter();
                    }
            }
            if ((dirtyFlags & 0xeL) != 0) {

                    if (model != null) {
                        // read model.showEmpty
                        modelShowEmpty = model.showEmpty;
                    }
                    updateRegistration(1, modelShowEmpty);


                    if (modelShowEmpty != null) {
                        // read model.showEmpty.get()
                        modelShowEmptyGet = modelShowEmpty.get();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            com.example.tmdbexample.bindings.CustomViewBindings.bindRecyclerViewAdapter(this.listOfMovies, modelGetAdapter);
        }
        if ((dirtyFlags & 0xeL) != 0) {
            // api target 1

            this.mboundView3.setVisibility(modelShowEmptyGet);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            this.spinnerLoading.setVisibility(modelLoadingGet);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): model.loading
        flag 1 (0x2L): model.showEmpty
        flag 2 (0x3L): model
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}