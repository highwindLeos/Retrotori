/**
 * 
 */

$(document).ready(function() {
	$('.boardLike').hover(function() {
		$(this).html('<i class="fas fa-heart"></i> 좋아요');
	});
	$('.boardLike').mouseout(function() {
		$(this).html('좋아요');
	});
}); // 좋아요 버튼 올리기이벤트