<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<footer>
	<div class="container">

		<div class="copy text-center">
			Copyright 2017 &copy; <a href='#'>Vinaenter Edu</a>
		</div>

	</div>
</footer>
<div id='toTop' class="btn btn-primary btn-lg back-to-top"><span class="glyphicon glyphicon-chevron-up"></span></div>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://code.jquery.com/jquery.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script
	src="${defines.urlAdmin }/bootstrap/js/bootstrap.min.js"></script>
<script src="${defines.urlAdmin }/js/custom.js"></script>
    <script type="text/javascript">
    $(window).scroll(function() {
        if ($(this).scrollTop()) {
            $('#toTop').fadeIn();
        } else {
            $('#toTop').fadeOut();
        }
    });

    $("#toTop").click(function () {
       $("html, body").animate({scrollTop: 0}, 100);
    });
    </script>
</body>
</html>