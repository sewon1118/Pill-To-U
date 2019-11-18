package persistence.dao;

import java.util.List;

import model.Member;
import service.dto.MemberDTO;

public interface MemberDAO {

	
	public List<MemberDTO> getMemberList();
	public Member getMemberByEmail(String email);
	public int insertMember(MemberDTO mem);
	public int updateMember(MemberDTO mem);
	public int deleteMember(int m_id);
}