// Admin Order Management JavaScript

// View order detail
function viewOrderDetail(orderId) {
    window.location.href = `/admin/order/detail/${orderId}`;
}

// Process order (change status to processing)
function processOrder(orderId) {
    if (confirm(`주문 ${orderId}를 처리하시겠습니까?`)) {
        updateOrderStatus(orderId, 'PROCESSING', '주문이 처리 상태로 변경되었습니다.');
    }
}

// Ship order (change status to shipping)
function shipOrder(orderId) {
    if (confirm(`주문 ${orderId}를 배송 시작하시겠습니까?`)) {
        updateOrderStatus(orderId, 'SHIPPING', '배송이 시작되었습니다.');
    }
}

// Complete order (change status to completed)
function completeOrder(orderId) {
    if (confirm(`주문 ${orderId}를 완료 처리하시겠습니까?`)) {
        updateOrderStatus(orderId, 'COMPLETED', '주문이 완료되었습니다.');
    }
}

// Cancel order
function cancelOrder(orderId) {
    const reason = prompt('취소 사유를 입력해주세요:');
    if (reason) {
        updateOrderStatus(orderId, 'CANCELLED', '주문이 취소되었습니다.', reason);
    }
}

// Refund order
function refundOrder(orderId) {
    const reason = prompt('환불 사유를 입력해주세요:');
    if (reason) {
        updateOrderStatus(orderId, 'REFUNDED', '환불 처리되었습니다.', reason);
    }
}

// Update order status
function updateOrderStatus(orderId, status, message, reason = null) {
    const data = {
        orderId: orderId,
        status: status,
        reason: reason
    };
    
    fetch(`/admin/order/status`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            showAlert(message, 'success');
            // Update UI
            updateOrderStatusBadge(orderId, status);
        } else {
            showAlert('상태 변경에 실패했습니다: ' + (data.message || ''), 'danger');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        showAlert('주문 상태 변경 중 오류가 발생했습니다.', 'danger');
    });
}

// Update order status badge in UI
function updateOrderStatusBadge(orderId, status) {
    const row = document.querySelector(`tr[data-order-id="${orderId}"]`);
    if (!row) return;
    
    const badge = row.querySelector('.order-status-badge');
    if (!badge) return;
    
    // Remove all status classes
    badge.className = 'badge order-status-badge';
    
    // Add new status class
    switch(status) {
        case 'NEW':
            badge.className += ' bg-warning';
            badge.textContent = '신규주문';
            break;
        case 'PROCESSING':
            badge.className += ' bg-info';
            badge.textContent = '처리중';
            break;
        case 'SHIPPING':
            badge.className += ' bg-primary';
            badge.textContent = '배송중';
            break;
        case 'COMPLETED':
            badge.className += ' bg-success';
            badge.textContent = '배송완료';
            break;
        case 'CANCELLED':
            badge.className += ' bg-danger';
            badge.textContent = '취소';
            break;
        case 'REFUNDED':
            badge.className += ' bg-secondary';
            badge.textContent = '환불';
            break;
    }
}

// Filter orders
function filterOrders() {
    const statusFilter = document.getElementById('orderStatusFilter');
    const dateFromFilter = document.getElementById('dateFrom');
    const dateToFilter = document.getElementById('dateTo');
    const searchInput = document.getElementById('orderSearch');
    
    const status = statusFilter?.value || '';
    const dateFrom = dateFromFilter?.value || '';
    const dateTo = dateToFilter?.value || '';
    const searchTerm = searchInput?.value.toLowerCase() || '';
    
    const rows = document.querySelectorAll('.order-table tbody tr');
    
    rows.forEach(row => {
        let show = true;
        
        // Status filter
        if (status && row.dataset.status !== status) {
            show = false;
        }
        
        // Date filter
        if (dateFrom || dateTo) {
            const orderDate = row.dataset.date;
            if (orderDate) {
                if (dateFrom && orderDate < dateFrom) show = false;
                if (dateTo && orderDate > dateTo) show = false;
            }
        }
        
        // Search filter
        if (searchTerm) {
            const text = row.textContent.toLowerCase();
            if (!text.includes(searchTerm)) {
                show = false;
            }
        }
        
        row.style.display = show ? '' : 'none';
    });
    
    // Update visible count
    updateVisibleOrderCount();
}

// Update visible order count
function updateVisibleOrderCount() {
    const visibleRows = document.querySelectorAll('.order-table tbody tr:not([style*="display: none"])');
    const countElement = document.getElementById('visibleOrderCount');
    
    if (countElement) {
        countElement.textContent = `${visibleRows.length}개 주문 표시중`;
    }
}

// Export orders to Excel
function exportOrders() {
    const format = confirm('Excel 형식으로 내보내시겠습니까?\n(취소를 누르면 CSV 형식으로 내보냅니다)') ? 'excel' : 'csv';
    
    window.location.href = `/admin/order/export?format=${format}`;
}

// Print order
function printOrder(orderId) {
    window.open(`/admin/order/print/${orderId}`, '_blank', 'width=800,height=600');
}

// Batch process orders
function batchProcessOrders(action) {
    const checkboxes = document.querySelectorAll('input[name="orderSelect"]:checked');
    
    if (checkboxes.length === 0) {
        showAlert('처리할 주문을 선택해주세요.', 'warning');
        return;
    }
    
    const orderIds = Array.from(checkboxes).map(cb => cb.value);
    
    let confirmMessage = '';
    switch(action) {
        case 'process':
            confirmMessage = `선택한 ${orderIds.length}개 주문을 처리하시겠습니까?`;
            break;
        case 'ship':
            confirmMessage = `선택한 ${orderIds.length}개 주문을 배송 시작하시겠습니까?`;
            break;
        case 'complete':
            confirmMessage = `선택한 ${orderIds.length}개 주문을 완료 처리하시겠습니까?`;
            break;
    }
    
    if (confirm(confirmMessage)) {
        // Process batch update
        fetch('/admin/order/batch', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                orderIds: orderIds,
                action: action
            })
        })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                showAlert(`${data.processed}개 주문이 처리되었습니다.`, 'success');
                setTimeout(() => location.reload(), 1500);
            } else {
                showAlert('일괄 처리에 실패했습니다.', 'danger');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            showAlert('일괄 처리 중 오류가 발생했습니다.', 'danger');
        });
    }
}

// Initialize order page
document.addEventListener('DOMContentLoaded', function() {
    // Add event listeners for filters
    const statusFilter = document.getElementById('orderStatusFilter');
    const dateFromFilter = document.getElementById('dateFrom');
    const dateToFilter = document.getElementById('dateTo');
    const searchInput = document.getElementById('orderSearch');
    
    if (statusFilter) {
        statusFilter.addEventListener('change', filterOrders);
    }
    
    if (dateFromFilter) {
        dateFromFilter.addEventListener('change', filterOrders);
    }
    
    if (dateToFilter) {
        dateToFilter.addEventListener('change', filterOrders);
    }
    
    if (searchInput) {
        searchInput.addEventListener('input', filterOrders);
    }
    
    // Select all checkbox
    const selectAllCheckbox = document.getElementById('selectAllOrders');
    if (selectAllCheckbox) {
        selectAllCheckbox.addEventListener('change', function() {
            const checkboxes = document.querySelectorAll('input[name="orderSelect"]');
            checkboxes.forEach(cb => cb.checked = this.checked);
        });
    }
    
    // Initialize order count
    updateVisibleOrderCount();
});