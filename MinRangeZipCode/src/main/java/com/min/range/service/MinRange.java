package com.min.range.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.min.range.pojo.Range;

public class MinRange {

	List<Range> list = new ArrayList<Range>();
	
	public List<Range> minr(Range r){
				boolean flag = false;
				if(list.isEmpty() || list.size()==0){
					list.add(r);
				}
				else{
					
					Iterator<Range> iterator = list.iterator();	
					while(iterator.hasNext()){
						Range listr = iterator.next();
						boolean isRemove = false;
						if(r.low>=0 && r.high>=0){
							if(r.low > listr.high || r.high < listr.low){
								isRemove = false;
							}
							if(r.low-listr.high == 1 && r.low > listr.low){
								r.low = (listr.low);
								isRemove = true;
							}
							if(listr.low-r.high==1 && r.high < listr.high){
								r.high = (listr.high);
								isRemove = true;
							}
							if((listr.low <= r.low) && (r.low <= listr.high)){
								r.low = (listr.low);
								isRemove = true;
							}
							if((listr.low <= r.high) && (r.high <= listr.high)){
								r.high = (listr.high);
								isRemove = true;
							}
							if(r.low <= listr.low && r.high>=listr.high){
								isRemove = true;
							}
							if(isRemove){
								iterator.remove();
							}
							flag = true;
						}
						else if(r.low >= listr.low && r.high <= listr.high){
							flag = false;
						}
					}
					
					if(flag){
						//Adding r to the list depending on flag value
						list.add(r);
					}
				}
				return list;
	}

	public List<Range> getList() {
		return list;
	}

	public void setList(List<Range> list) {
		this.list = list;
	}
}
