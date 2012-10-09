package com.friends.help.dao;

import java.util.Set;

import com.friends.help.forms.Clusters;

public interface Clustersdao {
	
	public void addCluster(Clusters C);
	public void updateCluster(Clusters C);
	public void deletClusterobject(Clusters C);
	
	public Clusters getClustersObject(String clustname,int blockid);
	public Set<Clusters> getClustersList(int blockname);
	public Clusters getClustersObjectbyID(int clusterid);
	

}
