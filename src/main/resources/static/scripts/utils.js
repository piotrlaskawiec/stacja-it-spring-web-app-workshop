var SPRINGFUNAPP = SPRINGFUNAPP || (function($, window, undefined) {
    var cellWidth = 10, cellHeight = 10,
        availableRows = 100, availableColumns = 100,
        gridWidthInPx = 1002, gridHeightInPx = 1002;

    var _generateData = function() {
        var data = [], xpos = 1, ypos = 1;

        for (var row = 0; row < availableRows; row++) {
            data.push([]);

            for (var column = 0; column < availableColumns; column++) {
                data[row].push({
                    row: row,
                    column: column,
                    x: xpos,
                    y: ypos
                });
                xpos += cellWidth;
            }
            xpos = 1;

            ypos += cellHeight;
        }
        return data;
    };

    var _getSelectedColor = function() {
        return $('#colorPicker').val() || "#000";
    };

    var _reserve = function(url, pixel) {
        $
            .post(url, pixel)
            .done(function(data) {
                $("#tokens").html(data.wallet.tokens);
            })
            .fail(function() {
                alert("Cannot reserve this pixel!");
            });
    };

    var printGrid = function() {
        var grid = d3.select("#grid")
            .append("svg")
            .attr("width", gridWidthInPx + "px")
            .attr("height", gridHeightInPx + "px");

        var row = grid.selectAll(".row")
            .data(_generateData)
            .enter()
            .append("g")
            .attr("class", "row");

        row.selectAll(".square")
            .data(function(d) { return d; })
            .enter()
            .append("rect")
            .attr("class","square")
            .attr("x", function(d) { return d.x; })
            .attr("y", function(d) { return d.y; })
            .attr("width", cellWidth)
            .attr("height", cellHeight)
            .style("fill", "#fff")
            .style("stroke", "#222")
            .on('click', function(data) {
                // do nothing
            });
    };

    var initStreamOfEvents = function (url) {
        var eventSource = new EventSource(url);

        eventSource.onmessage = function (e) {
            var msg = JSON.parse(e.data);
            $('.row:eq(' + msg.row + ') .square:eq(' + msg.column + ')').css('fill', msg.color);
        };
    };

    var getAvailableTokens = function(url) {
        $.get(url, function(wallet) {
            $("#tokens").html(wallet.tokens);
        });
    };

    var getReservedPixels = function(url) {
        $.get(url, function(pixels) {
            pixels.forEach(function (pixel) {
                $('.row:eq(' + pixel.row + ') .square:eq(' + pixel.column + ')').css('fill', pixel.color);
            });
        });
    };

    return {
        printGrid: printGrid,
        initStreamOfEvents: initStreamOfEvents,
        getReservedPixels: getReservedPixels,
        getAvailableTokens: getAvailableTokens
    }
})(jQuery, window);