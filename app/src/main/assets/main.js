var selectionChange = function(){
    var selection = document.getSelection(),
        range = selection.getRangeAt(0),
        boundingRect = range.getBoundingClientRect(),
        rectList = range.getClientRects(),
        selectionText = selection.toString();

    var jsonInfo = {
        boundingRect: boundingRect,
        rectList: $.makeArray(rectList),
        selectionText: selectionText,
        isEmpty: selection.isCollapsed
    };
    ActivityInterface.selectionChange(JSON.stringify(jsonInfo));
};

$(function(){
    $(document).on('selectionchange', selectionChange);
});