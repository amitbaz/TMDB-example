package com.example.tmdbexample.databinding;
import com.example.tmdbexample.R;
import com.example.tmdbexample.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ViewMovieBindingImpl extends ViewMovieBinding  {

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
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final android.widget.ImageView mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ViewMovieBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 3, sIncludes, sViewsWithIds));
    }
    private ViewMovieBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (android.widget.TextView) bindings[2]
            );
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.ImageView) bindings[1];
        this.mboundView1.setTag(null);
        this.txtName.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
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
        if (BR.position == variableId) {
            setPosition((java.lang.Integer) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.example.tmdbexample.viewmodel.MoviesViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPosition(@Nullable java.lang.Integer Position) {
        this.mPosition = Position;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.position);
        super.requestRebind();
    }
    public void setViewModel(@Nullable com.example.tmdbexample.viewmodel.MoviesViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelImages((androidx.databinding.ObservableArrayMap<java.lang.String,java.lang.String>) object, fieldId);
            case 1 :
                return onChangeViewModelGetMovieAtPosition((com.example.tmdbexample.model.Movie) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelImages(androidx.databinding.ObservableArrayMap<java.lang.String,java.lang.String> ViewModelImages, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelGetMovieAtPosition(com.example.tmdbexample.model.Movie ViewModelGetMovieAtPosition, int fieldId) {
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
        androidx.databinding.ObservableArrayMap<java.lang.String,java.lang.String> viewModelImages = null;
        java.lang.String viewModelGetMovieAtPositionName = null;
        com.example.tmdbexample.model.Movie viewModelGetMovieAtPosition = null;
        java.lang.String viewModelImagesViewModelGetMovieAtPositionName = null;
        java.lang.Integer position = mPosition;
        com.example.tmdbexample.viewmodel.MoviesViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x1fL) != 0) {



                if (viewModel != null) {
                    // read viewModel.images
                    viewModelImages = viewModel.images;
                    // read viewModel.getMovieAt(position)
                    viewModelGetMovieAtPosition = viewModel.getMovieAt(position);
                }
                updateRegistration(0, viewModelImages);
                updateRegistration(1, viewModelGetMovieAtPosition);


                if (viewModelGetMovieAtPosition != null) {
                    // read viewModel.getMovieAt(position).name
                    viewModelGetMovieAtPositionName = viewModelGetMovieAtPosition.getName();
                }


                if (viewModelImages != null) {
                    // read viewModel.images[viewModel.getMovieAt(position).name]
                    viewModelImagesViewModelGetMovieAtPositionName = viewModelImages.get(viewModelGetMovieAtPositionName);
                }
        }
        // batch finished
        if ((dirtyFlags & 0x1fL) != 0) {
            // api target 1

            com.example.tmdbexample.bindings.CustomViewBindings.bindRecyclerViewAdapter(this.mboundView1, viewModelImagesViewModelGetMovieAtPositionName);
        }
        if ((dirtyFlags & 0x1eL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtName, viewModelGetMovieAtPositionName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.images
        flag 1 (0x2L): viewModel.getMovieAt(position)
        flag 2 (0x3L): position
        flag 3 (0x4L): viewModel
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}