package com.example.flickr_mvvm_architectural_component.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.flickr_mvvm_architectural_component.R;
import com.example.flickr_mvvm_architectural_component.data.remote.SearchImageAsyncTask;
import com.example.flickr_mvvm_architectural_component.databinding.SquareListImageBinding;
import com.example.flickr_mvvm_architectural_component.db.entity.ImageEntity;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;

public class SearchImageAdapter extends PagedListAdapter<ImageEntity, SearchImageViewHolder> {

	public SearchImageAdapter() {
		super(diffUtilItemCallback);
	}

	@NonNull
	@Override
	public SearchImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		SquareListImageBinding binding = DataBindingUtil
			.inflate(LayoutInflater.from(parent.getContext()), R.layout.square_list_image,
				parent, false);
		return new SearchImageViewHolder(binding);
	}


	@Override
	public void onBindViewHolder(@NonNull SearchImageViewHolder holder, int position) {
		ImageEntity searchImage = getItem(position);

		holder.cancelLoadImage();
		if (holder != null) {
			holder.getBinding().setSearchImage(searchImage);
			holder.getBinding().imageViewImage.setImageBitmap(null);
			holder.downloadImage(searchImage,
				new SearchImageAsyncTask(holder.getBinding().imageViewImage));
		}
	}

	@Override
	public long getItemId(int position) {
		return getItem(position).getId();
	}


	private static DiffUtil.ItemCallback<ImageEntity> diffUtilItemCallback = new DiffUtil.ItemCallback<ImageEntity>() {
		@Override
		public boolean areItemsTheSame(@NonNull ImageEntity oldItem,
			@NonNull ImageEntity newItem) {
			return newItem.getId() == oldItem.getId();
		}

		@Override
		public boolean areContentsTheSame(@NonNull ImageEntity oldItem,
			@NonNull ImageEntity newItem) {
			return oldItem.equals(newItem);
		}
	};

}

