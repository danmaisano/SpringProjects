<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Input Form</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <form action="/submit" method="post">
            <div class="form-group">
                <label for="number">Pick any number between 5 to 25</label>
                <input type="number" class="form-control" id="number" name="number" min="5" max="25" required>
            </div>
            <div class="form-group">
                <label for="city">Enter the name of any city</label>
                <input type="text" class="form-control" id="city" name="city" required>
            </div>
            <div class="form-group">
                <label for="person">Enter the name of any real person</label>
                <input type="text" class="form-control" id="person" name="person" required>
            </div>
            <div class="form-group">
                <label for="endeavor">Enter a professional endeavor or hobby</label>
                <input type="text" class="form-control" id="endeavor" name="endeavor" required>
            </div>
            <div class="form-group">
                <label for="livingThing">Enter any type of living thing</label>
                <input type="text" class="form-control" id="livingThing" name="livingThing" required>
            </div>
            <div class="form-group">
                <label for="niceWords">Say something nice to someone</label>
                <textarea class="form-control" id="niceWords" name="niceWords" rows="3" required></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>

    <!-- Bootstrap JS (Optional) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
