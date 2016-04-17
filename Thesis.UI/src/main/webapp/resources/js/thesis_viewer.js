/**
 * Created by Mustafa Tahir ARSLAN
 */
$(document).ready(function(){
    $('.student_activity_item').click(studentActivityItemClick);
});

function studentActivityItemClick() {
    $this = $(this);
    showActivityDetail($this);
    var studentActivityId = $this.attr('id').split("_")[2];
    selectStudentActivity([{name: 'studentActivityId', value: studentActivityId}]);
}

function showActivityDetail($item) {
    var id = $item.attr('id');
    var itemDetailId = "item_" + id;
    var $itemDetail = $('#' + itemDetailId);
    $item.animate({
        height: '145px',
        'background-color': '#FFF',
        color: '#000'
    }, 400, function() {
        $itemDetail.fadeIn();
    });
}

function hideActivityDetail() {

}