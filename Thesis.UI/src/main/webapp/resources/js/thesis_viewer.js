/**
 * Created by Mustafa Tahir ARSLAN
 */
$(document).ready(function(){
    $('.student_activity_item').click(studentActivityItemClick);
});

function studentActivityItemClick() {
    $this = $(this);
    showActivityDetail($this);
}

function showActivityDetail($item) {
    var id = $item.attr('id');
    var itemDetailId = "item_" + id;
    var $itemDetail = $('#' + itemDetailId);
    $item.animate({
        height: '350px',
        'background-color': '#FFF',
        color: '#000'
    }, 1000, function() {
        $itemDetail.fadeIn();
    });
}

function hideActivityDetail() {

}