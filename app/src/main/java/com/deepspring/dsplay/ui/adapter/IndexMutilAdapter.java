package com.deepspring.dsplay.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.deepspring.dsplay.R;
import com.deepspring.dsplay.bean.Banner;
import com.deepspring.dsplay.bean.IndexBean;
import com.deepspring.dsplay.ui.widget.BannerLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Anonym on 2017/5/15.
 */

public class IndexMutilAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_BANNER = 1;
    public static final int TYPE_ICON = 2;
    public static final int TYPE_APPS = 3;
    public static final int TYPE_GAMES = 4;

    private IndexBean mIndexBean;
    private LayoutInflater mLayoutInflater;

    public IndexMutilAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
    }

    public void setData(IndexBean indexBean) {
        mIndexBean = indexBean;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_BANNER;
        } else if (position == 1) {
            return TYPE_ICON;
        } else if (position == 2) {
            return TYPE_APPS;
        } else if (position == 3) {
            return TYPE_GAMES;
        }
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_BANNER) {
            return new BannerViewHolder(mLayoutInflater.inflate(R.layout.template_banner, parent, false));
        } else if (viewType == TYPE_ICON) {
            return new BannerViewHolder(mLayoutInflater.inflate(R.layout.template_banner, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
            List<Banner> banners = mIndexBean.getBanners();
            List<String> urls = new ArrayList<>(banners.size());
            for(Banner banner : banners) {
                urls.add(banner.getThumbnail());
            }
            bannerViewHolder.mBanner.setViewUrls(urls);
            bannerViewHolder.mBanner.setImageLoader(new BannerLayout.ImageLoader() {
                @Override
                public void displayImage(Context context, String path, ImageView imageView) {

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.banner)
        BannerLayout mBanner;
        public BannerViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this.itemView);
        }
    }

    class IconViewHolder extends RecyclerView.ViewHolder {

        public IconViewHolder(View itemView) {
            super(itemView);
        }
    }
}
