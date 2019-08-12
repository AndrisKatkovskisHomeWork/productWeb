function toggle(source) {
    checkboxes = document.getElementsByName('checkboxDVD');
    for(var i=0, n=checkboxes.length;i<n;i++) {
        checkboxes[i].checked = source.checked;
    }
}