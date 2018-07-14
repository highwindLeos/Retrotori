/**
 * 
 */

function validateForm() {
	
	var mPw = frm_join.mPw.value;
	var mPwchk = frm_join.mPwChk.value;
	
	if (mPw != mPwchk) {
		alert('확인 패스워드 틀림 : 패스워드 확인란을 확인해주세요.');
		mPw = "";
		mPwchk = "";
		frm_join.mPw.focus();
		return false;
	}
	
	return true;
}