try {
            $('a[href*=#]').click(function (e) {
                var href = $.attr(this, 'href');
                if (href != "#") {
                    $('html, body').animate({
                        scrollTop: $(href).offset().top - 81
                    }, 500);
                }
                else {
                    $('html, body').animate({
                        scrollTop: 0
                    }, 500);
                }
                return false;
            });

         
            var nt_title = $('#nt-title').newsTicker({
                row_height: 40,
                max_rows: 1,
                duration: 3000,
                pauseOnHover: 0
            });
            var nt_example1 = $('#nt-example1').newsTicker({
                row_height: 80,
                max_rows: 3,
                duration: 4000,
                prevButton: $('#nt-example1-prev'),
                nextButton: $('#nt-example1-next')
            });
            var nt_example2 = $('#nt-example2').newsTicker({
                row_height: 60,
                max_rows: 1,
                speed: 300,
                duration: 6000,
                prevButton: $('#nt-example2-prev'),
                nextButton: $('#nt-example2-next'),
                hasMoved: function () {
                    $('#nt-example2-infos-container').fadeOut(200, function () {
                        $('#nt-example2-infos .infos-hour').text($('#nt-example2 li:first span').text());
                        $('#nt-example2-infos .infos-text').text($('#nt-example2 li:first').data('infos'));
                        $(this).fadeIn(400);
                    });
                },
                pause: function () {
                    $('#nt-example2 li i').removeClass('fa-play').addClass('fa-pause');
                },
                unpause: function () {
                    $('#nt-example2 li i').removeClass('fa-pause').addClass('fa-play');
                }
            });
            $('#nt-example2-infos').hover(function () {
                nt_example2.newsTicker('pause');
            }, function () {
                nt_example2.newsTicker('unpause');
            });
            var state = 'stopped';
            var speed;
            var add;
            var nt_example3 = $('#nt-example3').newsTicker({
                row_height: 80,
                max_rows: 1,
                duration: 0,
                speed: 10,
                autostart: 0,
                pauseOnHover: 0,
                hasMoved: function () {
                    if (speed > 700) {
                        $('#nt-example3').newsTicker("stop");
                        console.log('stop')
                        $('#nt-example3-button').text("RESULT: " + $('#nt-example3 li:first').text().toUpperCase());
                        setTimeout(function () {
                            $('#nt-example3-button').text("START");
                            state = 'stopped';
                        }, 2500);

                    }
                    else if (state == 'stopping') {
                        add = add * 1.4;
                        speed = speed + add;
                        console.log(speed)
                        $('#nt-example3').newsTicker('updateOption', "duration", speed + 25);
                        $('#nt-example3').newsTicker('updateOption', "speed", speed);
                    }
                }
            });
        } catch (e) {

        }