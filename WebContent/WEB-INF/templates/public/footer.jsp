<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <a href="javascript:" id="toTop"><i class="icon-chevron-up"></i></a>
		<section id="footer_bottom_area">
			<div class="clearfix wrapper footer_bottom">
				<div class="clearfix copyright floatleft">
					<p> Copyright &copy; VinaEnter Edu. All rights reserved. Code by <span>Gia Huy</span></p>
				</div>
				<div class="clearfix social floatright">
					<ul>
						<li><a class="tooltip" title="Facebook" href=""><i class="fa fa-facebook-square"></i></a></li>
						<li><a class="tooltip" title="Twitter" href=""><i class="fa fa-twitter-square"></i></a></li>
						<li><a class="tooltip" title="Google+" href=""><i class="fa fa-google-plus-square"></i></a></li>
					</ul>
				</div>
			</div>
		</section>
		
		<script src="${defines.urlAdmin }/bootstrap/js/bootstrap.min.js"></script>
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
		
		<script type="text/javascript" src="${defines.urlPublic }/js/jquery.tooltipster.min.js"></script>		
		<script type="text/javascript">
			$(document).ready(function() {
				$('.tooltip').tooltipster();
			});
		</script>
		 <script type="text/javascript" src="${defines.urlPublic }/js/selectnav.min.js"></script>
		<script type="text/javascript">
			selectnav('nav', {
			  label: '-Navigation-',
			  nested: true,
			  indent: '-'
			});
		</script>		
		<script src="${defines.urlPublic }/js/pgwslider.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$('.pgwSlider').pgwSlider({
					intervalDuration: 5000
				});
			});
		</script>
		<script type="text/javascript" src="${defines.urlPublic }/js/placeholder_support_IE.js"></script>
	</body>
</html>
