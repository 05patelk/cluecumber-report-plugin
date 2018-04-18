<script src="js/jquery.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/datatables.min.js"></script>
<script src="js/jquery.fancybox.min.js"></script>
<script src="js/Chart.bundle.min.js"></script>

<script>
    $(document).ready(function () {
        // Data tables
        $('table').on('draw.dt', function () {
            $('[data-toggle="tooltip"]').tooltip();
        }).DataTable();

        // Lightbox
        $("a.grouped_elements").fancybox();

        // Tool tips
        $('[data-toggle="tooltip"]').tooltip();

        // Chart
        var ctx = document.getElementById('chart-area').getContext("2d");
        new Chart(ctx, eval(${reportDetails.chartJson}));
    })
</script>