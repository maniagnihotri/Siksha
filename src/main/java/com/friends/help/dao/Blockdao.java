package com.friends.help.dao;

import java.util.List;
import java.util.Set;

import com.friends.help.forms.Block;

public interface Blockdao {
	
	public void addBlock(Block B);
	public void updateBlock(Block B);
	public void deletBlockobject(Block B);
	
	public Set<Block> getBlocks(int districtid);
	//public boolean deleteBlocks(String districtname);
	public Block getBlockobject(int district,String blockname);
	public Block getBlockobjectbyID(int blockid);
	public List<String> getBlocknames(int districtid);

}
