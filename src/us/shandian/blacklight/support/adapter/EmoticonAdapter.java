/* 
 * Copyright (C) 2014 Peter Cai
 *
 * This file is part of BlackLight
 *
 * BlackLight is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * BlackLight is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with BlackLight.  If not, see <http://www.gnu.org/licenses/>.
 */

package us.shandian.blacklight.support.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Map.Entry;

import us.shandian.blacklight.R;
import us.shandian.blacklight.support.Emoticons;

public class EmoticonAdapter extends BaseAdapter
{
	private ArrayList<String> mNames = new ArrayList<String>();
	private ArrayList<Bitmap> mBitmaps = new ArrayList<Bitmap>();
	
	private LayoutInflater mInflater;
	
	public EmoticonAdapter(Context context) {
		mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		for (Entry<String, Bitmap> entry : Emoticons.EMOTICON_BITMAPS.entrySet()) {
			mNames.add(entry.getKey());
			mBitmaps.add(entry.getValue());
		}
	}
	
	@Override
	public int getCount() {
		return mNames.size();
	}

	@Override
	public String getItem(int position) {
		return mNames.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (position >= mNames.size()){
			return convertView;
		} else {
			View v = mInflater.inflate(R.layout.emoticon_view, null);
			ImageView iv = (ImageView) v.findViewById(R.id.emoticon_image);
			iv.setImageBitmap(mBitmaps.get(position));
			return v;
		}
	}

}
