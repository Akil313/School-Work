var ctx = document.getElementById("pieChart");
var myDoughnutChart = new Chart(ctx, {
    type: 'doughnut',
    data: data = {
        datasets: [{
            data: [1283, 312, 534],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)'
            ]
        }],

        labels: [
            "Pele",
            "Maradona",
            "Messi"
        ]
    }
});