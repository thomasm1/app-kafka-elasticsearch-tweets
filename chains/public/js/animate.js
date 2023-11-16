var cube = $('.cube');

function rotateCube(horiz, vert, newInset, newSide) {
  // hide features on originally visible side of cube
  $('.nav, .insets>div').hide();
  // rotate cube a certain way on x and y axis
  cube.css('transform', 'rotateY(' + horiz + 'deg) rotateX(' + vert + 'deg)')
  .css('-webkit-transform', 'rotateY(' + horiz + 'deg) rotateX(' + vert + 'deg)');
  // change color of features to correspond with new side
  $('.nav').css('color', newSide.data('color'));
  newInset.css('background', newSide.data('bg'));
  // make features visible- nav buttons fade in further below
  newInset.delay(400).fadeIn(700);
}

var navFadeIn = function(thisNav) {
  $('.nav').not(thisNav).delay(400).fadeIn(700);
  $('.homeicon').fadeIn();
};

$(document).ready(function() {
  $('.preload').fadeOut();
  $('.homeicon').hide();
  // center inset becomes visible
  $('.centerInset').css('background', $('.centerFace').data('bg'));
  $('.centerSquare:nth-of-type(1)').css('background', $('.topFace').data('bg'));
  $('.centerSquare:nth-of-type(2)').css('background', $('.leftFace').data('bg'));
  $('.centerSquare:nth-of-type(3)').css('background', $('.rightFace').data('bg'));
  $('.centerSquare:nth-of-type(4)').css('background', $('.bottomFace').data('bg'));
  $('.centerInset').fadeIn();

  $('.toHome').hover(function() {
    $(this).css('cursor', 'pointer');
    $('.homeicon').css('text-shadow', '0 0 20px #fff');
  }, function() {
    $('.homeicon').css('text-shadow', 'none');
  });

  // move inset when hovering over nav buttons
  $('.toTop').hover(function() {
    $('.insets').css('transform', ' rotateX(-16deg)');
  }, function() {
    $('.insets').css('transform', 'rotateX(0)');
  });
  $('.toLeft').hover(function() {
    $('.insets').css('transform', ' rotateY(16deg)');
  }, function() {
    $('.insets').css('transform', 'rotateY(0)');
  });
  $('.toRight').hover(function() {
    $('.insets').css('transform', ' rotateY(-16deg)');
  }, function() {
    $('.insets').css('transform', 'rotateY(0)');
  });
  $('.toBottom').hover(function() {
    $('.insets').css('transform', ' rotateX(16deg)');
  }, function() {
    $('.insets').css('transform', 'rotateX(0)');
  });
  
  //move cube on click
  $('.toTop').click(function() {
    rotateCube(0, -90, $('.topInset'), $('.topFace'));
    navFadeIn(this);
   });
  $('.toLeft').click(function() {
    rotateCube(90, 0, $('.leftInset'), $('.leftFace'));
    navFadeIn(this);
   });
  $('.toRight').click(function() {
    rotateCube(-90, 0, $('.rightInset'), $('.rightFace'));
    rotateCube(-90, 0, $('.rightInset'), $('.rightFace'));
    navFadeIn(this);
  });
  $('.toBottom').click(function() {
    rotateCube(0, 90, $('.bottomInset'), $('.bottomFace'));
    navFadeIn(this);
   });
  $('.toHome, .insets>div').click(function() {
    rotateCube(0, 0, $('.centerInset'), $('.centerFace'));
    $('.homeicon').fadeOut();
    $('.nav').delay(400).fadeIn(700);
  });

}); //end ready