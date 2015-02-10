/**
 * 
 */

function submitStudentForm() {
    // getting the student form values
    var name = $('#name').val().trim();
    var rollNumber = $('#rollNumber').val();
    var cpi = $('#cpi').val();
    if(name.length ==0) {
        alert('Please enter name');
        $('#name').focus();
        return false;
    }

    if(rollNumber <= 0) {
        alert('Please enter proper rollNumber');
        $('#rollNumber').focus();
        return false;
    }

    if(cpi <= 0) {
        alert('Please enter proper cpi');
        $('#cpi').focus();
        return false;
    }
    return true;
};