// 使用 SweetAlert2 進行取消收藏
function openCancelModal(pdFavId) {
	Swal.fire({
		title: '確定要取消此商品收藏嗎？',
		text: '此操作無法復原！',
		icon: 'warning',
		showCancelButton: true,
		confirmButtonText: '確定',
		cancelButtonText: '取消',
		reverseButtons: true
	}).then((result) => {
		if (result.isConfirmed) {
			deleteFavorite(pdFavId);
		}
	});
}

// 發送請求取消收藏
function deleteFavorite(pdFavId) {
	$.ajax({
		url: '/pdFav/deleteFavorite',
		type: 'POST',
		data: { pdFavId: pdFavId },
		success: function(response) {
			Swal.fire({
				icon: 'success',
				title: '成功！',
				text: '商品收藏已取消！'
			}).then(() => {
				location.reload(); // 重新加載頁面
			});
		},
		error: function() {
			Swal.fire({
				icon: 'error',
				title: '錯誤！',
				text: '取消失敗，請稍後再試！'
			});
		}
	});
}