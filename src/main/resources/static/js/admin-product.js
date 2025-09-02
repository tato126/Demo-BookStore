// Admin Product Management JavaScript

// View product detail
function viewProductDetail(productId) {
    window.location.href = `/admin/product/detail/${productId}`;
}

// Edit product
function editProduct(productId) {
    window.location.href = `/admin/product/update/${productId}`;
}

// Delete product
function deleteProduct(productId) {
    if (confirm('정말로 이 상품을 삭제하시겠습니까?\n이 작업은 되돌릴 수 없습니다.')) {
        // Create form for DELETE request
        const form = document.createElement('form');
        form.method = 'POST';
        form.action = `/admin/product/detail/${productId}`;
        
        // Add method override for DELETE
        const methodInput = document.createElement('input');
        methodInput.type = 'hidden';
        methodInput.name = '_method';
        methodInput.value = 'DELETE';
        form.appendChild(methodInput);
        
        document.body.appendChild(form);
        form.submit();
    }
}

// Duplicate product
function duplicateProduct(productId) {
    if (confirm('이 상품을 복제하시겠습니까?')) {
        fetch(`/admin/product/duplicate/${productId}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            }
        })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                showAlert('상품이 복제되었습니다.', 'success');
                setTimeout(() => {
                    window.location.href = `/admin/product/detail/${data.newProductId}`;
                }, 1500);
            } else {
                showAlert('상품 복제에 실패했습니다.', 'danger');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            showAlert('상품 복제 중 오류가 발생했습니다.', 'danger');
        });
    }
}

// Calculate discount rate
function calculateDiscount() {
    const originalPrice = document.getElementById('originalPrice')?.value;
    const salePrice = document.getElementById('salePrice')?.value;
    const discountRateField = document.getElementById('discountRate');
    
    if (originalPrice && salePrice && discountRateField && originalPrice > 0) {
        const discount = ((originalPrice - salePrice) / originalPrice * 100).toFixed(1);
        discountRateField.value = discount > 0 ? discount : 0;
    }
}


// Cancel product registration
function cancelRegistration() {
    if (confirm('입력한 내용이 저장되지 않습니다. 취소하시겠습니까?')) {
        window.location.href = '/admin/product';
    }
}

// Search products
function searchProducts() {
    const searchInput = document.getElementById('productSearch');
    const categoryFilter = document.getElementById('categoryFilter');
    const stockFilter = document.getElementById('stockFilter');
    
    if (!searchInput) return;
    
    const searchTerm = searchInput.value.toLowerCase();
    const category = categoryFilter?.value || '';
    const stockStatus = stockFilter?.value || '';
    
    const rows = document.querySelectorAll('.product-table tbody tr');
    
    rows.forEach(row => {
        const text = row.textContent.toLowerCase();
        const rowCategory = row.dataset.category || '';
        const rowStock = parseInt(row.dataset.stock || '0');
        
        let show = true;
        
        // Text search
        if (searchTerm && !text.includes(searchTerm)) {
            show = false;
        }
        
        // Category filter
        if (category && rowCategory !== category) {
            show = false;
        }
        
        // Stock filter
        if (stockStatus) {
            if (stockStatus === 'available' && rowStock <= 0) show = false;
            if (stockStatus === 'low' && (rowStock <= 0 || rowStock > 10)) show = false;
            if (stockStatus === 'out' && rowStock > 0) show = false;
        }
        
        row.style.display = show ? '' : 'none';
    });
}

// Initialize product page
document.addEventListener('DOMContentLoaded', function() {
    // Add event listeners for search and filters
    const searchInput = document.getElementById('productSearch');
    const categoryFilter = document.getElementById('categoryFilter');
    const stockFilter = document.getElementById('stockFilter');
    
    if (searchInput) {
        searchInput.addEventListener('input', searchProducts);
    }
    
    if (categoryFilter) {
        categoryFilter.addEventListener('change', searchProducts);
    }
    
    if (stockFilter) {
        stockFilter.addEventListener('change', searchProducts);
    }
    
    // Add event listener for discount calculation
    const originalPriceInput = document.getElementById('originalPrice');
    const salePriceInput = document.getElementById('salePrice');
    
    if (originalPriceInput) {
        originalPriceInput.addEventListener('input', calculateDiscount);
    }
    
    if (salePriceInput) {
        salePriceInput.addEventListener('input', calculateDiscount);
    }
    
});