package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.dao.ILprodDao;
import kr.or.ddit.user.dao.LprodDaoImpl;
import kr.or.ddit.user.model.LprodVO;

public class LprodServiceImpl implements ILprodService{
	private ILprodDao dao = new LprodDaoImpl(); 

	@Override
	public List<LprodVO> getLprod() {
		return dao.getLprod();
	}

	@Override
	public List<LprodVO> getPageLprod(PageVO pageVo) {
		return dao.getPageLprod(pageVo);
	}

	@Override
	public int getLprodCnt() {
		return dao.getLprodCnt();
	}

	@Override
	public Map<String, Object> getPaging(PageVO pageVO) {
		Map<String, Object> map = new HashMap<String, Object>();
		int cnt = dao.getLprodCnt();
		int pagenation = (int)Math.ceil((double)cnt/pageVO.getPageSize());
		List<LprodVO> list = dao.getPageLprod(pageVO);
		
		map.put("pagenation", pagenation);
		map.put("pageList", list);
		
		return map;
	}
}
