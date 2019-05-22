<%@include file="/templates/taglib.jsp" %>
<div class="clearfix content">

                    <div class="contact_us">

                        <h1>Liên hệ với chúng tôi</h1>

                        <p>
                            TRUNG TÂM ĐÀO TẠO LẬP TRÌNH VINAENTER EDU<br /> Trụ sở: 154 Phạm Như Xương, Liên Chiểu, Đà Nẵng<br /> Web: <a href="http://vinaenter.edu.vn" title="">www.vinaenter.edu.vn</a>
                        </p>
						<c:if test="${not empty msg }">
							<div style="color:red;">
		  						<strong>${msg}</strong>
							</div>
						</c:if>
                        <form action="" method="post">
                            <p><input type="text" class="wpcf7-text" placeholder="Họ tên *" name="fullname" value="${contact.fullname }"/></p>
                            <form:errors path="contact.fullname" style="color:red;"></form:errors><br />
                            <p><input type="text" class="wpcf7-email" placeholder="Email *" name="email" value="${contact.email }"/></p>
                            <form:errors path="contact.email" style="color:red;"></form:errors><br />
                            <p><input type="text" class="wpcf7-text" placeholder="Chủ đề *" name="subject" value="${contact.subject }"/></p>
                            <form:errors path="contact.subject" style="color:red;"></form:errors><br />
                            <p><textarea class="wpcf7-textarea" placeholder="Nội dung *" name="content" >${contact.content }</textarea></p>
                            <form:errors path="contact.content" style="color:red;"></form:errors><br />
                            <p><input type="Submit" class="wpcf7-submit" value="Gửi liên hệ" /></p>
                        </form>

                    </div>

                </div>